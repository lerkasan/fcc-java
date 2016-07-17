'use strict';

// ************  Home Page  ******************
myApp.controller('homeController', function ($scope, $http) {
});

// ************  Register Page  ******************
myApp.controller('registerController', function ($scope, $http) {

    $scope.validate = function () {

        $scope.emailValidationError = "";
        $scope.passwordValidationError = "";
        $scope.usernameValidationError = "";
        // var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        var illegalUsernameChars = /\W/;


        if ($scope.account == null) {
            $scope.account = {};
        }

        /*   if (($scope.username == '') || ($scope.username == null)) {
         $scope.usernameValidationError = "Username is empty";
         }

         if (($scope.account.password == '') || ($scope.account.password == null)) {
         $scope.passwordValidationError = "Password is empty";
         }

         if (($scope.account.email == '') || ($scope.account.email == null)) {
         $scope.emailValidationError = "E-mail is empty";
         } */

        if (illegalUsernameChars.test($scope.account.username)) {
            $scope.usernameValidationError = "Please use only letters, numbers and underscopes in username";
        }

        if ($scope.account.password != $scope.account.password2) {
            $scope.passwordValidationError = "Passwords aren't equal";
        } else {
            $scope.submit();
        }

    }

    $scope.submit = function () {

        // var token = $("meta[name='_csrf']").attr("content");
        // var header = $("meta[name='_csrf_header']").attr("content");

        $http({
            method: 'POST',
            url: 'http://localhost:8080/#/register',
            //url: '#/register',
            data: $.param($scope.account),  // pass in data as strings
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}  // set the headers so angular passing info as form data (not request payload)
        })
            .then(function (response) {
                $scope.statusCode = response.status;
                $scope.data = response.data;
                alert("OK");
            }, function (response) {
                $scope.statusCode = response.status;
                $scope.errorEmail = "ERROR!!!"
                alert("BAD");
            });
    };

});

myApp.controller('signupController', function ($scope, $http) {
    $scope.passwordValidationError = "Passwords aren't equal";
});

// ************  Articles Page  ******************
myApp.controller('contactsController', function ($scope, $http) {
});

// ************  Info Page  ******************
myApp.controller('infoController', function ($scope, $http) {
});


// ************ ADMIN:  Admin Home Page  ******************
myAdmin.controller('adminHomeController', function ($scope, $http) {
});

// ************ ADMIN:  Admin Create Page  ******************
myAdmin.controller('adminCreateController', function ($scope, $http) {
});

// ************ ADMIN:  Admin Update Page  ******************
myAdmin.controller('adminUpdateController', function ($scope, $http) {
});

// ************ ADMIN:  Admin Delete Page  ******************
myAdmin.controller('adminDeleteController', function ($scope, $http) {
});

// ************ ADMIN:  Admin View Page  ******************
myAdmin.controller('adminViewController', function ($scope, $http) {
});

