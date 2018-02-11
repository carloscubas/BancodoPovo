$("#formhistorico").submit(
		function(event) {

			// Stop form from submitting normally
			event.preventDefault();

			var $form = $(this), 
				pValor = $form.find("input[name='valor']")
					.val(), pDescricao = $form.find("input[name='descricao']")
					.val(), pTipo = $("#tipo").val(), 
					
					pIdConta = $form.find("input[name='idConta']").val(), 
					
					url = $form.attr( "action" );
			
			$.ajax({
			    type: "POST",
			    url: url,
			    data: JSON.stringify({
					valor : pValor,
					descricao : pDescricao,
					tipo : pTipo,
					idConta : pIdConta 
				}),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    success: function(data){
			    	
			    		var json = JSON.stringify(data);
			    		
			    		var valorInicial = data['valorTotal'];
			    		var saldo = 0;
			    		
			    		html = '';
			    		
			    
			    		for(i = 0; i < data['historicos'].length; i++){
			    			html += '<tr>';
			    			html += '<td>' + data['historicos'][i].tipo + '</td>';
			    			html += '<td>' + data['historicos'][i].valor + '</td>';
			    			html += '<td>' + data['historicos'][i].descricao +'</td>';
			    			
			    			if(data['historicos'][i].tipo == 'C'){
			    				valorInicial += data['historicos'][i].valor;
			    			}else{
			    				valorInicial -= data['historicos'][i].valor;
			    			}
			    			
			    			html += '</tr>';
			    		}
			    		
			    		html += '<tr>';
			    		html += '<td class="a-center"></td>';
			    		html += '<td><b>' + valorInicial + '</b></td>';
					html += '<td></td>';
					html += '</tr>';
					
					
					$( "#listatabela" ).empty().append( html );
			    		
			    	},
			    failure: function(errMsg) {
		    			console.log("error: " + errMsg);
			    }
			});

			
		});