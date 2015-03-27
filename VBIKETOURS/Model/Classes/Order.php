<?php
class Order {
	
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_customer_id;
	private $_payment_type;
	private $_cart_id;
	private $_payment_succes;
	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

// 	public function __construct($id, $customer_id, $payment_type, $cart_id, $payment_succes)
// 	{
// 		$this->_id = set_id($id);
// 		$this->_customer_id = set_customer_id($customer_id);
// 		$this->_payment_type = set_payment_type($payment_type);
// 		$this->_cart_id = set_cart_id($cart_id);
// 		$this->_payment_succes = set_payment_succes($payment_succes);
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
	
	public function get_customer_id() {
		return $this->_customer_id;
	}
	
	public function get_payment_type() {
		return $this->_payment_type;
	}
	
	public function get_cart_id() {
		return $this->_cart_id;
	}
	
	public function get_payment_succes() {
		return $this->_payment_succes;
	}

	
/**********SETTERS***************/
	
	public function set_id($id) {
		$this->_id = $id;
	}
	
	public function set_customer_id($customer_id) {
		$this->_customer_id = $customer_id;
	}
	
	public function set_payment_type($payment_type) {
		$this->_payment_type = $payment_type;
	}
	
	public function set_cart_id($cart_id) {
		$this->_cart_id = $cart_id;
	}
	
	public function set_payment_succes($payment_succes) {
		$this->_payment_succes = $payment_succes;
	}
	
}
?>