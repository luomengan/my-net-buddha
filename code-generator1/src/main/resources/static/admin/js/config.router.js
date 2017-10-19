'use strict';

/**
 * Config for the router
 */
angular.module('app')

  .run([
    '$rootScope', 
    '$state', 
    '$stateParams',
    function ($rootScope, $state, $stateParams) {
      $rootScope.$state = $state;
      $rootScope.$stateParams = $stateParams;        
  }])

  .config([
    '$stateProvider', 
    '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
      $urlRouterProvider
        .otherwise('/app/index');

      $stateProvider
        .state('app', {
            abstract: true,
            url: '/app',
            templateUrl: 'tpl/app.html'
        })
        .state('app.index', {
            url: '/index',
            templateUrl: 'src/html/index.html',
            resolve: {
                deps: ['$ocLazyLoad',
                  function( $ocLazyLoad){
                    return $ocLazyLoad.load(['toaster']);
                }]
            }
        })
        
        .state('app.project', {
            url: '/project',
            templateUrl: 'src/html/project/project_admin.html',
            resolve: {
                deps: ['$ocLazyLoad',
                  function( $ocLazyLoad){
                    return $ocLazyLoad.load(['toaster']);
                }]
            }
        })
        .state('app.dataObject', {
            url: '/dataObject',
            templateUrl: 'src/html/dataObject/dataObject_admin.html',
            resolve: {
                deps: ['$ocLazyLoad',
                  function( $ocLazyLoad){
                    return $ocLazyLoad.load(['toaster']);
                }]
            }
        })
        .state('app.dataColumn', {
            url: '/dataColumn',
            templateUrl: 'src/html/dataColumn/dataColumn_admin.html',
            resolve: {
                deps: ['$ocLazyLoad',
                  function( $ocLazyLoad){
                    return $ocLazyLoad.load(['toaster']);
                }]
            }
        })

      }
    ]
  );