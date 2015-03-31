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
		$this->_price = $price;
	}
	
/*******ADD A BOOKING*********/
	public function add_booking($booking){
		$this->_booking_list[ $booking->get_id() ] = $booking;
		$this->add_price($booking->get_price());
	}
	
/*******REMOVE A BOOKING********/
	public function remove_booking($selected_booking){
		foreach ($this->_booking_list as $id=>$booking){
			if ($booking==$selected_booking)
				$this->_booking_list[$id]=null;
		}
	}
	
/******ADD A PRICE************/
	public function add_price($price){	
		$this->_price+=$price;
	}

/******REMOVE A PRICE************/
	public function remove_price($price){
		$this->_price-=$price;
	}
}
?>