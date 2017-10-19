'use strict';

angular.module('app', [
	'ngAnimate',
	'ngCookies',
	'ngResource',
	'ngSanitize',
	'ngTouch',
	'ngStorage',
	'ui.router',
	'ui.bootstrap',
	'ui.load',
	'ui.jq',
	'ui.validate',
	'oc.lazyLoad',
	'pascalprecht.translate', 
    
	'index'
    	, 'projectAdmin'
	, 'dataObjectAdmin'
	, 'dataColumnAdmin'
]);

angular.module('index', [])
    .controller('indexController', indexControllerFn);

function indexControllerFn($scope, toaster, $http, tokenService) {
    $scope.buildProject = function(isValid) {
    	if(isValid) {
    		var projectId = $scope.project.id;
    		$http({
                method: 'post',
                url: '/code-generator1/work/buildProject',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                    'Authorization': tokenService.getToken()
                },
                data: "projectId="+projectId
            }).then(function(response) {
                if(response.data.code === "200") {
                	alert("构建项目成功!");
                    $scope.project.id = '';
                } else {
                	alert(response.data.exception.message + '!');              
                }
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
    	}
    }
}