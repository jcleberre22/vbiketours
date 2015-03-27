<?php
class Order_DAO
{
  private $_db; // PDO instance

  public function __construct($db)
  {
    $this->setDb($db);
  }

  public function add(Order $order)
  {
    $query = $this->_db->prepare('INSERT INTO order SET customer_id = :customer_id, payment_type = :payment_type, cart_id = :cart_id, payment_succes = :payment_succes, vehicle = :vehicle, duration = :duration, style = :style, route = :route, nb_passenger_max = :nb_passenger_max, price = :price, start_time = :start_time, validity_start = :validity_start, validity_end = :validity_end, picture = :picture');

    $query->bindValue(':customer_id', $order->get_customer_id(), PDO::PARAM_INT);
    $query->bindValue(':payment_type', $order->get_payment_type());
    $query->bindValue(':cart_id', $order->get_cart_id(), PDO::PARAM_INT);
    $query->bindValue(':payment_succes', $order->get_payment_succes());

    $query->execute();
  }

  public function delete(Order $order)
  {
    $this->_db->exec('DELETE FROM order WHERE id = '.$order->id());
  }

  public function get($id)
  {
    $id = (int) $id;

    $query = $this->_db->query('SELECT * FROM order WHERE id = '.$id);
    $orders = $query->fetch(PDO::FETCH_ASSOC);

    return new Order($orders);
  }

  public function getList()
  {
    $orders = [];

    $query = $this->_db->query('SELECT * FROM order ORDER BY customer_id');

    while ($datas = $query->fetch(PDO::FETCH_ASSOC))
    {
      $orders[] = new Order($datas);
    }

    return $orders;
  }

  public function update(Order $order)
  {
    $query = $this->_db->prepare('UPDATE order SET customer_id = :customer_id, payment_type = :payment_type, cart_id = :cart_id, payment_succes = :payment_succes WHERE id = :id');

    $query->bindValue(':customer_id', $order->get_customer_id(), PDO::PARAM_INT);
    $query->bindValue(':payment_type', $order->get_payment_type());
    $query->bindValue(':cart_id', $order->get_cart_id(), PDO::PARAM_INT);
    $query->bindValue(':payment_succes', $order->get_payment_succes());
    $query->bindValue(':id', $order->get_id(), PDO::PARAM_INT);

    $query->execute();
  }

  public function setDb(PDO $db)
  {
    $this->_db = $db;
  }
}
?>