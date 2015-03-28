<?php
class Booking {
	 const CHILDREN_PROMOTION=0.5;
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_date;
	private $_nb_adults;
	private $_nb_childrens;
	private $_tour_id;
	private $_price;
	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

	public function __construct($id, $date, $nb_adults, $nb_childrens, $tour_id, $price)
	{
		$this->set_id($id);
		$this->set_date($date);
		$this->set_nb_adults($nb_adults);
		$this->set_nb_childrens($nb_childrens);
		$this->set_tour_id($tour_id);
		$this->set_price($price);
	}
	
	public function tostring(){
		echo $this->_id."<br><br>";
		echo $this->_date."<br><br>";
		echo $this->_nb_adults."<br><br>";
		echo $this->_nb_childrens."<br><br>";
		echo $this->_tour_id."<br><br>";
		echo $this->_price."<br><br>";
	}

	
/**********GETTERS***************/
	
	public function get_id() {
		return $this->_id;
	}
	
	public function get_date() {
		return $this->_date;
	}
	
	public function get_nb_adults() {
		return $this->_nb_adults;
	}
	
	public function get_nb_childrens() {
		return $this->_nb_childrens;
	}
	
	public function get_tour_id() {
		return $this->_tour_id;
	}
	
	public function get_price() {
		return $this->_price;
	}
	
/**********SETTERS***************/
	
	public function set_id($id) {
		$this->_id = $id;
	}
	
	public function set_date($date) {
		$this->_date = $date;
	}
	
	public function set_nb_adults($nb_adults) {
		$this->_nb_adults = $nb_adults;
	}
	
	public function set_nb_childrens($nb_childrens) {
		$this->_nb_childrens = $nb_childrens;
	}
	
	public function set_tour_id($tour_id) {
		$this->_tour_id = $tour_id;
	}
	
	public function set_price($price) {
		$booking_price=($price*$this->_nb_adults)+($price*$this->_nb_childrens*self::CHILDREN_PROMOTION);
		$this->_price = $booking_price;
	}
}
?>