<?php 
foreach ($_GET as $datas => $value){
	$$datas = $value;
}
?>
<section>
<div class="table-responsive">
<table class="table table-bordered">
	<thead>
		<th>h</th>
		<th>h</th>
		<th>h</th>
		<th>h</th>
		<th>h</th>
		<th>h</th>
	</thead>
	<tbody>
		<tr>
			<td>a</td>
			<td>b</td>
			<td>c</td>
			<td>d</td>
			<td>e</td>
			<td>f</td>
		</tr>
				<tr>
			<td>a</td>
			<td>b</td>
			<td>c</td>
			<td>d</td>
			<td>e</td>
			<td>f</td>
		</tr>
				<tr>
			<td>a</td>
			<td>b</td>
			<td>c</td>
			<td>d</td>
			<td>e</td>
			<td>f</td>
		</tr>
		
	</tbody>
	<tfoot>
		<th>1</th>
		<th>2</th>
		<th>3</th>
		<th>4</th>
		<th>5</th>
		<th>6</th>
	</tfoot>
</table>
</div>
			<a href="index.php?page=paypal_after_success&token=<?php $list_param_paypal['TOKEN'] ?> >
				<button id="checkout_infos_submit" name="checkout_infos_submit" type="button" class="btn-pink btn-effect col-xs-12 col-md-4">
					<?php $order_type="Confirm payment"; echo $order_type;?>
				</button>
			</a>
</section>

