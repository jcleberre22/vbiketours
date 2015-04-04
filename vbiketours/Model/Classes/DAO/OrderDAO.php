<?php
class OrderDAO{
  private $_db; // PDO instance

  public function __construct($db)
  {
    $this->setDb($db);
  }

  public function add(Order $order)
  {
  	try {
  		$query = $this->_db->prepare('INSERT INTO order SET cart = :cart, payment_type = :payment_type, payment_method = :payment_method, payment_succes = :payment_succes, customer_id = :customer_id');
  		
  		$query->bindValue(':cart', $order->get_cart());
  		$query->bindValue(':payment_type', $order->get_payment_type());
  		$query->bindValue(':payment_method', $order->get_payment_method());
  		$query->bindValue(':payment_succes', $order->get_payment_succes());
  		$query->bindValue(':customer_id', $order->get_customer_id(), PDO::PARAM_INT);
  		
  		$query->execute();
  		return true;
  	} catch (Exception $e) {
  		echo 'adding failed, error: '.$e->getmessage();
  		return false;
  	}
  }

  public function delete(Order $order)
  {
    $this->_db->exec('DELETE FROM order WHERE id = '.$order->id());
    return true;
  }

  public function get($id)
  {
    $id = (int) $id;

    $query = $this->_db->query('SELECT * FROM order WHERE id = '.$id);
    $orderDatas = $query->fetch(PDO::FETCH_ASSOC);

    return new Order($orderDatas);
  }

  public function getList()
  {
    $orders = [];
    
    $query = $this->_db->query('SELECT * FROM order ORDER BY customer_id');
	if($query!=null){
    while ($datas = $query->fetch(PDO::FETCH_ASSOC))
    {
      $orders[] = new Order($datas);
    }
	}
    return $orders;
  }

  public function update(Order $order)
  {
    $query = $this->_db->prepare('UPDATE order SET cart = :cart, payment_type = :payment_type, payment_method = :payment_method, payment_succes = :payment_succes, customer_id = :customer_id');
    
    $query->bindValue(':cart', $order->get_cart());
    $query->bindValue(':payment_type', $order->get_payment_type());
    $query->bindValue(':payment_method', $order->get_payment_method());
    $query->bindValue(':payment_succes', $order->get_payment_succes());
    $query->bindValue(':customer_id', $order->get_customer_id(), PDO::PARAM_INT);
    
    $query->execute();
  }

  public function setDb(PDO $db)
  {
    $this->_db = $db;
  }
}
?>