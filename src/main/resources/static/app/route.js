angular.module("RoomsManagerApp").config(function($stateProvider, $urlRouteProvider){
	
	//The ui router will redirect if a invalid state has come
	$stateProvider.state('nav', {
		abstract: true,
		url: '',
		views : {
			'nav@' :{
				templateUrl: 'app/views/nav.html',
				controller: 'NavController'
			}
		}
	}).state('login', {
		parent: 'nav',
		url: '/login',
		views : {
			'content@' :{
				templateUrl: 'app/views/login.html',
				controller: 'LoginController'
			}
		}
	}).state('users', {
		parent: 'nav',
		url: '/users',
		data: {
			role: 'ADMIN'
		},
		views : {
			'content@' :{
				templateUrl: 'app/views/users.html',
				controller: 'UsersController'
			}
		}
	}).state('home', {
		parent: 'nav',
		url: '/',
		views : {
			'content@' :{
				templateUrl: 'app/views/home.html',
				controller: 'LoginController'
			}
		}
	}).state('page-not-found', {
		parent : 'nav',
		url : '/page-not-found',
		views : {
			'content@' : {
				templateUrl : 'app/views/page-not-found.html',
				controller : 'PageNotFoundController'
			}
		}
	}).state('access-denied', {
		parent: 'nav',
		url: '/access-denied',
		views : {
			'content@' :{
				templateUrl: 'app/views/access-denied.html',
				controller: 'AccessDeniedController'
			}
		}
	})
});