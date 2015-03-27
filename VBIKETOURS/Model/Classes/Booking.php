<?php
class Booking {
	
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_date;
	private $_nb_persons;
	private $_tour_id;
	private $_price;
	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

	public function __construct($id, $date, $nb_persons, $tour_id, $price)
	{
		$this->_id = set_id($id);
		$this->_date = set_date($date);
		$this->_nb_persons = set_nb_persons($nb_persons);
		$this->_tour_id = set_tour_id($tour_id);
		$this->_price = set_price($price);
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
	
	public function set_tour_id($tour_id) {
		$this->_tour_id = $tour_id;
	}
	
	public function set_price($price) {
		$this->_price = $price;
	}
	
}
?>