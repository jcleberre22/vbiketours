<?php
class CustomerIterator implements Iterator{
	private $customer_datas;
	private $position;
	
    public function __construct($customer_datas) {
        $this -> customer_datas = $customer_datas;
    	$this -> position = 0;
    }

    function rewind() {
        var_dump(__METHOD__);
        $this->position = 0;
    }

    function current() {
        var_dump(__METHOD__);
        return $this->customer_datas[$this->position];
    }

    function key() {
        var_dump(__METHOD__);
        return $this->position;
    }

    function next() {
        var_dump(__METHOD__);
        ++$this->position;
    }

    function valid() {
        var_dump(__METHOD__);
        return isset($this->customer_datasy[$this->position]);
    }
}