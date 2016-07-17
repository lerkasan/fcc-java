'use strict';

var myApp = angular.module('myApp', ["ngRoute"]).config(function ($routeProvider) {

    $(".button-collapse").sideNav();

    // ************  Home Page  ******************
    $routeProvider.when('/home',
        {
            templateUrl: './home.html',
            controller: 'homeController'
        });

    // ************  Articles Page  ******************
    $routeProvider.when('/contacts',
        {
            templateUrl: './contacts.html',
            controller: 'contactsController'
        });

    // ************  Info Page  ******************
    $routeProvider.when('/info',
        {
            templateUrl: './info.html',
            controller: 'infoController'
        });

    // ************  Register Page  ******************
    $routeProvider.when('/register',
        {
            templateUrl: './register.html',
            controller: 'registerController'
        });

    // ************  Default Page  ******************
    $routeProvider.otherwise({redirectTo: '/home'});
});

var myAdmin = angular.module('myAdmin', ["ngRoute"]).config(function ($routeProvider) {

    // ************  Home Page  ******************
    $routeProvider.when('/home',
        {
            templateUrl: './admin/adminHome.html',
            controller: 'adminHomeController'
        });

    // ************  Create Page  ******************
    $routeProvider.when('/create',
        {
            templateUrl: './admin/adminCreate.html',
            controller: 'adminCreateController'
        });

    // ************  Update Page  ******************
    $routeProvider.when('/update',
        {
            templateUrl: './admin/adminUpdate.html',
            controller: 'adminUpdateController'
        });

    // ************  Delete Page  ******************
    $routeProvider.when('/delete',
        {
            templateUrl: './admin/adminDelete.html',
            controller: 'adminDeleteController'
        });

    // ************  View Page  ******************
    $routeProvider.when('/view',
        {
            templateUrl: './admin/adminView.html',
            controller: 'adminViewController'
        });

    // ************  Default Page  ******************
    $routeProvider.otherwise({redirectTo: '/home'});
});



