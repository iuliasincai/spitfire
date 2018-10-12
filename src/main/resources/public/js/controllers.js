angular.module('app.controllers', []).controller('ActivityController', function($scope, $state, popupService, $window, Activity) {
  $scope.activities = Activity.query(); //fetch all activities. Issues a GET to /api/vi/activities

  $scope.deleteActivity = function(activity) { // Delete am Activity. Issues a DELETE to /api/v1/activities/:id
    if (popupService.showPopup('Really delete this?')) {
        activity.$delete(function() {
        $scope.activities = Activity.query();
        $state.go('activities');
      });
    }
  };
}).controller('ActivityViewController', function($scope, $stateParams, Activity) {
  $scope.activity = Activity.get({ id: $stateParams.id }); //Get a single activity. Issues a GET to /api/v1/activities/:id
}).controller('ActivityCreateController', function($scope, $state, $stateParams, Activity) {
  $scope.activity = new Activity();  //create new activity instance. Properties will be set via ng-model on UI

  $scope.addActivity = function() { //create a new activity. Issues a POST to /api/v1/activities
    $scope.activity.$save(function() {
      $state.go('activities'); // on success go back to the list i.e. activities state.
    });
  };
}).controller('ActivityEditController', function($scope, $state, $stateParams, Activity) {
  $scope.updateActivity = function() { //Update the edited activity. Issues a PUT to /api/v1/activities/:id
    $scope.activity.$update(function() {
      $state.go('activities'); // on success go back to the list i.e. activities state.
    });
  };

  $scope.loadActivity = function() { //Issues a GET request to /api/v1/activities/:id to get a activity to update
    $scope.activity = Activity.get({ id: $stateParams.id });
  };

  $scope.loadActivity(); // Load a activity which can be edited on UI
});
