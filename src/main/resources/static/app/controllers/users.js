angular.module('RoomsManagerApp')
// Creating the Angular Controller
.controller('UsersController', function($http, $scope, AuthService) {
	var edit = false;
	$scope.buttonText = 'Create';
	var init = function() {
		$http.get('api/users').success(function(res) {
			$scope.users = res;
			
			$scope.userForm.$setPristine();
			$scope.message='';
			$scope.currentUser = null;
			$scope.buttonText = 'Create';
			
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.initEdit = function(currentUser) {
		edit = true;
		$scope.currentUser = currentUser;
		$scope.message='';
		$scope.buttonText = 'Update';
	};
	
	$scope.initAddUser = function() {
		edit = false;
		$scope.currentUser = null;
		$scope.userForm.$setPristine();
		$scope.message='';
		$scope.buttonText = 'Create';
	};
	$scope.deleteUser = function(currentUser) {
		$http.delete('api/users/'+currentUser.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			init();
		}).error(function(error) {
			$scope.deleteMessage = error.message;
		});
	};
	var editUser = function(){
		$http.put('api/users', $scope.currentUser).success(function(res) {
			$scope.currentUser = null;
			$scope.confirmPassword = null;
			$scope.userForm.$setPristine();
			$scope.message = "Editting Success";
			init();
		}).error(function(error) {
			$scope.message =error.message;
		});
	};
	var addUser = function(){
		$http.post('api/users', $scope.currentUser).success(function(res) {
			$scope.currentUser = null;
			$scope.confirmPassword = null;
			$scope.userForm.$setPristine();
			$scope.message = "User Created";
			init();
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	$scope.submit = function() {
		if(edit){
			editUser();
		}else{
			addUser();	
		}
	};
	init();

});
