angular.module('app.services', []).factory('Activity', function($resource) {
  return $resource('/api/v1/activities/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
