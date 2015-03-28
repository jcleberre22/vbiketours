<?php
class Booking {
	 const CHILDREN_PROMOTION=0.5;
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_date;
	private $_nb_persons;
	private $_nb_childrens;
	private $_tour_id;
	private $_price;
	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

	public function __construct($id, $date, $nb_persons, $nb_childrens, $tour_id, $price)
	{
		$this->_id = $this->set_id($id);
		$this->_date = $this->set_date($date);
		$this->_nb_persons = $this->set_nb_persons($nb_persons);
		$this->_nb_childrens = $this->set_nb_childrens($nb_childrens);
		$this->_tour_id = $this->set_tour_id($tour_id);
		$this->_price = $this->set_price($price);
	}

	
/**********GETTERS***************/
	
	public function get_id() {
		return $this->_id;
	}
	
	public function get_date() {
		return $this->_date;
	}
	
	public function get_nb_persons() {
		return $this->_nb_persons;
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
	
	public function set_nb_persons($nb_persons) {
		$this->_nb_persons = $nb_persons;
	}
	
	public function set_nb_childrens($nb_childrens) {
		$this->_nb_childrens = $nb_childrens;
	}
	
	public function set_tour_id($tour_id) {
		$this->_tour_id = $tour_id;
	}
	
	public function set_price($price) {
		$booking_price=($price*$this->_nb_persons)+($price*$this->_nb_childrens*self::CHILDREN_PROMOTION);
		$this->_price = $booking_price;
	}
}
?>