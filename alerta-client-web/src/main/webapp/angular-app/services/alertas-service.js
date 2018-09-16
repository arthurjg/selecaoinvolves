/**
 * 
 */
app.factory('alertas-service', ['$http', function($http) { 
	
	var alertasService = {
		list: function(){				
			return $http.get('http://localhost:8080/alertas').then();				
		}           
	};
  
	return alertasService;
}]);