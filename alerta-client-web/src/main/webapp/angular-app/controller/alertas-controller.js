/**
 * 
 */
app.controller('AlertasController', ['$scope', '$window',
      'alertas-service',  function($scope, $window, alertasService) {		
	
	$scope.alertas = [];	
	
	$scope.listar = function(){
		
		alertasService.list().then(function(response) {					
			$scope.alertas = response.data;
		},
		function(response) {		
			console.log("erro?...");			
		});		
	}		
	
}]);
