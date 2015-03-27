<?php
class Cart {
	
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_booking_list;
	private $_price;

	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

	public function __construct($id, $booking_list, $price)
	{
		$this->_id = set_id($id);
		$this->_booking_list = set_booking_list($booking_list);
		$this->_price = set_price($price);
	}


	
/**********GETTERS***************/
	
	public function get_id() {
		return $this->_id;
	}
	
	public function get_booking_list() {
		return $this->_booking_list;
	}
	
	public function get_price() {
		return $this->_price;
	}
	
	
/**********SETTERS***************/
	
	public function set_id($id) {
		$this->_id = $id;
	}
	
	public function set_booking_list($booking_list) {
		$this->_booking_list = $booking_list;
	}
	
	public function set_price($price) {
		$this->_price = $price;
	}
		
}
?>