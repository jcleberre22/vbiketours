<?php
class Vehicle {
	
/**********ATTRIBUTES***************/
	
	private $_id;
	private $_name;
	
/**********CONSTRUCTOR***************/
	
//  Classic Constructor

// 	public function __construct($id, $name)
// 	{
// 		$this->_id = set_id($id);
// 		$this->_name = set_name($name);
// 	}

//  Auto-hydrate Constructor 

	public function __construct(array $vehicle_datas)
	{
		$this->hydrate($vehicle_datas);
	}
			
/**********HYDRATATION***************/
	
//Receive all attributes from an array
	public function hydrate(array $vehicle_datas)
	{
		foreach ($vehicle_datas as $key => $value)
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
	
/**********SETTERS***************/
	
	public function set_id($id) {
		$this->_id = $id;
	}
	
	public function set_name($name) {
		$this->_name = $name;
	}
	
}
?>