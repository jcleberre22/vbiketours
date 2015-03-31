<?php
class Cart {
	
/**********ATTRIBUTES***************/
	
	private $_booking_list;
	private $_price;

	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

	public function __construct($booking_list, $price)
	{
		$this->set_booking_list($booking_list);
		$this->set_price($price);
	}


	
/**********GETTERS***************/
	
	public function get_booking_list() {
		return $this->_booking_list;
	}
	
	public function get_price() {
		return $this->_price;
	}
	
	
/**********SETTERS***************/
	
	
	public function set_booking_list($booking_list) {
		$this->_booking_list = $booking_list;
	}
	
	public function set_price($price) {
		$this->_price += $price;
	}
		
}
?>