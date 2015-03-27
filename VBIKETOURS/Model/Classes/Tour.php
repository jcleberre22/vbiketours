<?php
class Tour {
	
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_name;
	private $_summary;
	private $_description;
	private $_fitness;
	private $_vehicle;
	private $_duration;
	private $_style;
	private $_route;
	private $_nb_passenger_max;
	private $_price;
	private $_start_time;
	private $_validity_start;
	private $_validity_end;
	private $_picture;
	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

// 	public function __construct($id, $name, $summary, $description, $fitness, $vehicle, $duration, $style, $route, $nb_passenger_max, $price, $start_time, $validity_start, $validity_end, $picture)
// 	{
// 		$this->_id = set_id($id);
// 		$this->_name = set_name($name);
// 		$this->_summary = set_summary($summary);
// 		$this->_description = set_description($description);
// 		$this->_fitness = set_fitness($fitness);
// 		$this->_vehicle = set_vehicle($vehicle);
// 		$this->_duration = set_duration($duration);
// 		$this->_style = set_style($style);
// 		$this->_route = set_route($route);
// 		$this->_nb_passenger_max = set_nb_passenger_max($nb_passenger_max);
// 		$this->_price = set_price($price);
// 		$this->_start_time = set_start_time($start_time);
// 		$this->_validity_start = set_validity_start($validity_start);
// 		$this->_validity_start = set_validity_start($validity_start);
// 		$this->_validity_start = set_validity_start($validity_start);
// 	}

//  Auto-hydrate Constructor 

	public function __construct(array $tour_datas)
	{
		$this->hydrate($tour_datas);
	}
			
/**********HYDRATATION***************/
	
//Receive all attributes from an array
	public function hydrate(array $tour)
	{
		foreach ($tour as $key => $value)
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
	
	public function get_name() {
		return $this->_name;
	}
	
	public function get_summary() {
		return $this->_summary;
	}
	
	public function get_description() {
		return $this->_description;
	}
	
	public function get_fitness() {
		return $this->_fitness;
	}
	
	public function get_vehicle() {
		return $this->_vehicle;
	}
	
	public function get_duration() {
		return $this->_duration;
	}
	
	public function get_style() {
		return $this->_style;
	}
	
	public function get_route() {
		return $this->_route;
	}
	
	public function get_nb_passenger_max() {
		return $this->_nb_passenger_max;
	}
	
	public function get_price() {
		return $this->_price;
	}
	
	public function get_start_time() {
		return $this->_start_time;
	}
	
	public function get_validity_start() {
		return $this->_validity_start;
	}
	
	public function get_validity_end() {
		return $this->_validity_end;
	}
	
	public function get_picture() {
		return $this->_picture;
	}
	
/**********SETTERS***************/
	
	public function set_id($id) {
		$this->_id = $id;
	}
	
	public function set_name($name) {
		$this->_name = $name;
	}
	
	public function set_summary($summary) {
		$this->_summary = $summary;
	}
	
	public function set_description($description) {
		$this->_description = $description;
	}
	
	public function set_fitness($fitness) {
		$this->_fitness = $fitness;
	}
	
	public function set_vehicle($vehicle) {
		$this->_vehicle = $vehicle;
	}
	
	public function set_duration($duration) {
		$this->_duration = $duration;
	}
	
	public function set_style($style) {
		$this->_style = $style;
	}
	
	public function set_route($route) {
		$this->_route = $route;
	}
	
	public function set_nb_passenger_max($nb_passenger_max) {
		$this->_nb_passenger_max = $nb_passenger_max;
	}
	
	public function set_price($price) {
		$this->_price = $price;
	}
	
	public function set_start_time($start_time) {
		$this->_start_time = $start_time;
	}
	
	public function set_validity_start($validity_start) {
		$this->_validity_start = $validity_start;
	}
	
	public function set_validity_end($validity_end) {
		$this->_validity_end = $validity_end;
	}
	
	public function set_picture($picture) {
		$this->_picture = $picture;
	}
	
}
?>