var app = angular.module("moduleHistorico",[]);



function ListaHistoricoController($scope) {
	
	$scope.itens = [
		{tipo: 'C',
        valor: 300000,
        descricao: 'TESTE'}
		];
	
	$scope.loadtable = function (value) {
		
			var itens = [];
			var valorInicial = 0;
			
			$.ajax({
			    type: "GET",
			    url: "/historico/listhistorico/"+value,
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
			    	
			    		var json = JSON.stringify(data);
			    		
			    		var valorInicial = data['valorTotal'];
			    		$scope.idconta = data['id'];
			    		var saldo = 0;
			    
			    		for(i = 0; i < data['historicos'].length; i++){
			    			
			    			itens.push(
			    	        		{
			    	        			tipo: data['historicos'][i].tipo,
		                        valor: data['historicos'][i].valor,
		                        descricao: data['historicos'][i].descricao
		                     });
			    			
			    			if(data['historicos'][i].tipo == 'C'){
			    				valorInicial += data['historicos'][i].valor;
			    			}else{
			    				valorInicial -= data['historicos'][i].valor;
			    			}
			    		}
			    		
			    	},
			    failure: function(errMsg) {
		    			console.log("error: " + errMsg);
			    }
			});
			
    			$scope.valorFinal = valorInicial;
			$scope.itens = itens;
	};
		    
    $scope.adicionaItem = function () {
	       $scope.itens.push({tipo: $scope.item.tipo,
	                           valor: $scope.item.valor,
	                           descricao: $scope.item.descricao});
    };
    
   
}

app.controller("ListaHistoricoController",ListaHistoricoController);