<?php
class Customer {
	
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_country;
	private $_first_name;
	private $_last_name;
	private $_address;
	private $_city;
	private $_email;
	private $_phone;
	private $_pickup_location;
	private $_additional_infos;

	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

// 	public function __construct($id, $country, $first_name, $last_name, $address, $city, $email, $phone, $pickup_location, $additional_infos)
// 	{
// 		$this-> set_id($id);
// 		$this-> set_country($country);
// 		$this-> set_first_name($first_name);
// 		$this-> set_last_name($last_name);
// 		$this-> set_address($address);
// 		$this-> set_city($city);
// 		$this-> set_email($email);
// 		$this-> set_phone($phone);
// 		$this-> set_pickup_location($pickup_location);
// 		$this-> set_additional_infos($additional_infos);
// 	}

//  Auto-hydrate Constructor 

	public function __construct(array $customer_datas)
	{
		$this->hydrate($customer_datas);
	}
			
/**********HYDRATATION***************/
	
//Receive all attributes from an array
	public function hydrate(array $customer)
	{
		foreach ($customer as $key => $value)
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
	
	public function get_country() {
		return $this->_country;
	}
	
	public function get_first_name() {
		return $this->_first_name;
	}
	
	public function get_last_name() {
		return $this->_last_name;
	}
	
	public function get_address() {
		return $this->_address;
	}
	
	public function get_city() {
		return $this->_city;
	}
	
	public function get_email() {
		return $this->_email;
	}
	
	public function get_phone() {
		return $this->_phone;
	}
	
	public function get_pickup_location() {
		return $this->_pickup_location;
	}
	
	public function get_additional_infos() {
		return $this->_additional_infos;
	}

	
/**********SETTERS***************/
	
	public function set_id($id) {
		$this->_id = $id;
	}
	
	public function set_country($country) {
		$this->_country = $country;
	}
	
	public function set_first_name($first_name) {
		$this->_first_name = $first_name;
	}
	
	public function set_last_name($last_name) {
		$this->_last_name = $last_name;
	}
	
	public function set_address($address) {
		$this->_address = $address;
	}
	
	public function set_city($city) {
		$this->_city = $city;
	}
	
	public function set_email($email) {
		$this->_email = $email;
	}
	
	public function set_phone($phone) {
		$this->_phone = $phone;
	}
	
	public function set_pickup_location($pickup_location) {
		$this->_pickup_location = $pickup_location;
	}
	
	public function set_additional_infos($additional_infos) {
		$this->_additional_infos = $additional_infos;
	}

	
}
?>