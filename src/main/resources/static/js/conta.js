$( "#formhistorico" ).submit(function( event ) {
	
	console.log("postei o form");
 
  // Stop form from submitting normally
  event.preventDefault();
 
  // Get some values from elements on the page:
  var $form = $( this ), 
  pValor = $form.find( "input[name='valor']" ).val(), 
  pDescricao = $form.find( "input[name='descricao']" ).val(),
  pTipo = $( "#tipo" ).val(),
  pIdConta = $form.find( "input[name='idConta']" ).val(),
  url = $form.attr( "action" );
 
  // Send the data using post
  var posting = $.post( url, { valor: pValor, descricao: pDescricao, tipo: pTipo, idConta: pIdConta } );
 
  // Put the results in a div
  posting.done(function( data ) {
	  console.log(data);
	  
    var content = $( data ).find( "#content" );
    
    console.log(content);
    $( "#listatabela" ).empty().append( data );
    
  });
});