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
            templateUrl: 'src/html/index.html'
        })
        
        <#list dataObjectPojoList as being>
        .state('app.${being.humpName}', {
            url: '/${being.humpName}',
            templateUrl: 'src/html/${being.humpName}/${being.humpName}_admin.html',
            resolve: {
                deps: ['$ocLazyLoad',
                  function( $ocLazyLoad){
                    return $ocLazyLoad.load(['toaster']);
                }]
            }
        })
		</#list>

      }
    ]
  );