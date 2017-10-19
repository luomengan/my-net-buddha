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
    <#list dataObjectPojoList as being>
	, '${being.humpName}Admin'
	</#list>
]);

angular.module('index', [])
    .controller('indexController', indexControllerFn);

function indexControllerFn($scope) {
    
}