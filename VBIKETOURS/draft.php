Your cart is empty!<br><br>
				<a href="index.php">Back to the Main Page</a>
				
-------------------------------------------------------------------------------------------------------------------------------------------------------------

$(document).ready(function(){
	$("#form_tour").validate({
		rules: {}
	        checkinput:{
	            required: true
	        }
	   		
	   		checktextarea:{
	   			required: true
	   		}
       		checkint:{
       			required: true  
       		}
	   
       		checkdate:{
       			required: true
       		}
	   
	   		checktime:{
	   			required: true
	   		}
	   
	   		checkfile:{
	   			required: true    
	   		}
	    });
    ();
});