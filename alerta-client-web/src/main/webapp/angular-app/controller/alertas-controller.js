/**
 * 
 */
app.controller('AlertasController', ['$scope', '$window',
      'alertas-service',  function($scope, $window, alertasService) {			
	
	$scope.init = function(){
		$scope.alertas = [];	
		$scope.alertasOriginal = [];	
		$scope.listar();
		$scope.filtroPDV = "";
		$scope.filtroTipo = 0;		
		
		$scope.tiposAlertas = [
		   { nome: "Ruptura", flTipo: 1},
		   { nome: "Preço Abaixo", flTipo: 3},
		   { nome: "Preço Acima", flTipo: 2},
		   { nome: "Participação Abaixo", flTipo: 5},
		   { nome: "Participação Acima", flTipo: 4}		   
		];	
	}
	
	$scope.listar = function(){
		
		alertasService.list().then(function(response) {					
			$scope.alertas = response.data;
			$scope.alertasOriginal = $scope.alertas;
		},
		function(response) {		
			console.log("erro?..." + response.data);			
		});		
	}	
	
	$scope.filtrar = function(){	
		var alertasFiltrado = [];	
		
		var filtraPDV = $scope.filtroPDV.length > 0;	
		var filtraTipo = $scope.filtroTipo != 0;			
		
		for (var i = 0; i < $scope.alertasOriginal.length; i++) {
			var alerta = $scope.alertasOriginal[i];			
			
			if(!filtraTipo || alerta.flTipo == $scope.filtroTipo){
				if(!filtraPDV || alerta.pontoDeVenda.search($scope.filtroPDV) > 0){
					alertasFiltrado.push(alerta);					
				}							
			}	
		}	
		
		$scope.alertas = alertasFiltrado;
		
	}	
	
}]);
