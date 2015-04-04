<?php
class Order {
	
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_cart;
	private $_payment_type;
	private $_payment_method;
	private $_payment_succes;
	private $_customer_id;
	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

// 	public function __construct($id, $cart, $payment_type,$payment_method, $payment_succes, $customer_id)
// 	{
// 		$this-> set_id($id);
// 		$this-> set_cart($cart);
// 		$this-> set_payment_type($payment_type);
//		$this-> set_payment_method($payment_method);
// 		$this-> set_payment_succes($payment_succes);
// 		$this-> set_customer_id($customer_id);
// 	}

//  Auto-hydrate Constructor 

	public function __construct(array $order_datas)
	{
		$this->hydrate($order_datas);
	}
			
/**********HYDRATATION***************/
	
//Receive all attributes from an array
	public function hydrate(array $order)
	{
		foreach ($order as $key => $value)
		{
			// Get the setter name from attribute's name
			$method = 'set_'.ucfirst($key);
	
			// if the setter exist
			if (method_exists($this, $method))
			{
				// call the setter
				$this->$method($value);
			}
		}
	}
	
/**********GETTERS***************/
	
	public function get_id() {
		return $this->_id;
	}
	
	public function get_cart() {
		return $this->_cart;
	}
		
	public function get_payment_type() {
		return $this->_payment_type;
	}
	
	public function get_payment_method(){
		return  $this->_payment_method;
	}
	
	public function get_payment_succes() {
		return $this->_payment_succes;
	}
	
	public function get_customer_id() {
		return $this->_customer_id;
	}
	
	
/**********SETTERS***************/
	
	public function set_id($id) {
		$this->_id = $id;
	}
	
	public function set_cart($cart) {
		$this->_cart = $cart;
	}
	
	public function set_payment_type($payment_type) {
		$this->_payment_type = $payment_type;
	}
	
	public function  set_payment_method($payment_method){
		$this->_payment_method = $payment_method;
	}
	
	public function set_payment_succes($payment_succes) {
		$this->_payment_succes = $payment_succes;
	}
	
	public function set_customer_id($customer_id) {
		$this->_customer_id = $customer_id;
	}
	
}
?>