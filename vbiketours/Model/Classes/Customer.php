<?php
class Customer{
	
/**********ATTRIBUTES***************/
	
	private $_customer_id;
	private $_customer_country;
	private $_customer_first_name;
	private $_customer_last_name;
	private $_customer_address_1;
	private $_customer_address_2;
	private $_customer_city;
	private $_customer_state;
	private $_customer_post_code;
	private $_customer_email;
	private $_customer_phone;
	private $_customer_pickup_location;
	private $_customer_additional_infos;

	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

// 	public function __construct($id, $country, $first_name, $last_name, $address_1, $address_2 $city, $state, $post_code, $email, $phone, $pickup_location, $additional_infos)
// 	{
// 		$this-> set_customer_id($id);
// 		$this-> set_customer_country($country);
// 		$this-> set_customer_first_name($first_name);
// 		$this-> set_customer_last_name($last_name);
// 		$this-> set_customer_address($address_1);
// 		$this-> set_customer_address($address_2);
// 		$this-> set_customer_city($city);
// 		$this-> set_customer_state($state);
// 		$this-> set_customer_post_code($post_code);	
// 		$this-> set_customer_email($email);
// 		$this-> set_customer_phone($phone);
// 		$this-> set_customer_pickup_location($pickup_location);
// 		$this-> set_customer_additional_infos($additional_infos);
// 	}

//  Auto-hydrate Constructor 

	public function __construct(array $customer_datas)
	{
		$this->hydrate($customer_datas);
	}
			
/**********HYDRATATION***************/
	
//Receive all attributes from an array
	public function hydrate(array $customer_datas)
	{
		foreach ($customer_datas as $key => $value)
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
	
	public function get_customer_id() {
		return $this->_customer_id;
	}
	
	public function get_customer_country() {
		return $this->_customer_country;
	}
	
	public function get_customer_first_name() {
		return $this->_customer_first_name;
	}
	
	public function get_customer_last_name() {
		return $this->_customer_last_name;
	}
	
	public function get_customer_address_1() {
		return $this->_customer_address_1;
	}
	
	public function get_customer_address_2() {
		return $this->_customer_address_2;
	}
	
	public function get_customer_city() {
		return $this->_customer_city;
	}

	public function get_customer_state() {
		return $this->_customer_state;
	}
	
	public function get_customer_post_code() {
		return $this->_customer_post_code;
	}
	
	public function get_customer_email() {
		return $this->_customer_email;
	}
	
	public function get_customer_phone() {
		return $this->_customer_phone;
	}
	
	public function get_customer_pickup_location() {
		return $this->_customer_pickup_location;
	}
	
	public function get_customer_additional_infos() {
		return $this->_customer_additional_infos;
	}

	
/**********SETTERS***************/
	
	public function set_customer_id($id) {
		$this->_customer_id = $id;
	}
	
	public function set_customer_country($country) {
		$this->_customer_country = $country;
	}
	
	public function set_customer_first_name($first_name) {
		$this->_customer_first_name = $first_name;
	}
	
	public function set_customer_last_name($last_name) {
		$this->_customer_last_name = $last_name;
	}
	
	public function set_customer_address_1($address_1) {
		$this->_customer_address_1 = $address_1;
	}

	public function set_customer_address_2($address_2) {
		$this->_customer_address_2 = $address_2;
	}
	
	public function set_customer_city($city) {
		$this->_customer_city = $city;
	}

	public function set_customer_state($state) {
		$this->_customer_state = $state;
	}
	
	public function set_customer_post_code($post_code) {
		$this->_customer_post_code = $post_code;
	}
	
	public function set_customer_email($email) {
		$this->_customer_email = $email;
	}
	
	public function set_customer_phone($phone) {
		$this->_customer_phone = $phone;
	}
	
	public function set_customer_pickup_location($pickup_location) {
		$this->_customer_pickup_location = $pickup_location;
	}
	
	public function set_customer_additional_infos($additional_infos) {
		$this->_customer_additional_infos = $additional_infos;
	}
	
}
?>