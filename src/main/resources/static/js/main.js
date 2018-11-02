var app = angular.module("springDemo", []);
app.controller("AppCtrl", function ($scope, $http) {

	$scope.websites = [];

	$http.get("/api/heapoverflow").then(function(response) {
        $scope.websites = response.data;
    });

});
