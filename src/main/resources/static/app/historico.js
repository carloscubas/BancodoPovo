var app = angular.module("moduleHistorico",[]);

function ListaHistoricoController($scope, $http) {
	
	$scope.loadtable = function (value) {
		
			$scope.itens = [];
		
			var itens = [];
			var valorInicial = 0;
			
			$http({
	            method : "GET",
	            url : "/historico/listhistorico/"+value
	        }).then(function mySuccess(response) {
	        	
		        	var valorInicial = response.data.valorTotal;
		    
		    		for(i = 0; i < response.data.historicos.length; i++){
		    			
		    			$scope.itens.push(
		    	        		{
		    	        			tipo: response.data.historicos[i].tipo,
		    	        			valor: response.data.historicos[i].valor,
		    	        			descricao: response.data.historicos[i].descricao
		    	        		});
		    			
		    			if(response.data.historicos[i].tipo == 'C'){
		    				valorInicial += response.data.historicos[i].valor;
		    			}else{
		    				valorInicial -= response.data.historicos[i].valor;
		    			}
		    		}
		    		$scope.valorFinal = valorInicial;
	        	
	        	
	        }, function myError(response) {
	            console.log(response);
	        });
	};
		    
    		$scope.adicionaItem = function (value) {
    			
    			console.log(JSON.stringify({
					valor : $scope.item.valor,
					descricao : $scope.item.descricao,
					tipo : $scope.item.tipo,
					idConta : value 
				}));
	       
	       $http({
	            method : "POST",
	            url : "/historico/addhistorico",
	            data:JSON.stringify({
					valor : $scope.item.valor,
					descricao : $scope.item.descricao,
					tipo : $scope.item.tipo,
					idConta : value 
				})
	        }).then(function mySuccess(response) {
	            console.log("sucess: " + response);
	        		$scope.loadtable(value);
	        }, function myError(response) {
	            console.log("error: " + response);
	        });
	       
    };
}

app.controller("ListaHistoricoController",ListaHistoricoController);