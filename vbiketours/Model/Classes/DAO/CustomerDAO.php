<?php
class CustomerDAO
{
  private $_db; // PDO instance

  public function __construct($db)
  {
    $this->setDb($db);
  }

  public function add(Customer $customer)
  {
    $query = $this->_db->prepare('INSERT INTO customer SET country = :country, first_name = :first_name, last_name = :last_name, address_1 = :address_1, address_2 = :address_2, city = :city, state= :state, post_code= :post_code, email = :email, phone = :phone, pickup_location = :pickup_location, additional_infos = :additional_infos');

    $query->bindValue(':country', $customer->get_customer_country());
    $query->bindValue(':first_name', $customer->get_customer_first_name());
    $query->bindValue(':last_name', $customer->get_customer_last_name());
    $query->bindValue(':address_1', $customer->get_customer_address_1());
    $query->bindValue(':address_2', $customer->get_customer_address_2());
    $query->bindValue(':city', $customer->get_customer_city());
    $query->bindValue(':state', $customer->get_customer_state());
    $query->bindValue(':post_code', $customer->get_customer_post_code(), PDO:: PARAM_INT);
    $query->bindValue(':email', $customer->get_customer_email());
    $query->bindValue(':phone', $customer->get_customer_phone());
    $query->bindValue(':pickup_location', $customer->get_customer_pickup_location());
    $query->bindValue(':additional_infos', $customer->get_customer_additional_infos());

    $query->execute();
  }

  public function delete(Customer $customer)
  {
    $this->_db->exec('DELETE FROM customer WHERE id = '.$customer->id());
  }

  public function get($id)
  {
    $id = (int) $id;

    $query = $this->_db->query('SELECT * FROM customer WHERE id = '.$id);
    $customer_details = $query->fetch(PDO::FETCH_ASSOC);
    return new Customer($customer_details);
  }

  public function getList()
  {
    $customers = [];
    $query = $this->_db->query('SELECT * FROM customer ORDER BY country');
    
    if($query!=null){
    while ($datas = $query->fetch(PDO::FETCH_ASSOC))
    {
      $customers[] = new Customer($datas);
    }
    }
    return $customers;
  }
 

  public function update(Customer $customer)
  {
    $query = $this->_db->prepare('UPDATE customer SET country = :country, first_name = :first_name, last_name = :last_name, address_1 = :address_1, address_2 = :address_2, city = :city, state= :state, post_code= :post_code, email = :email, phone = :phone, pickup_location = :pickup_location, additional_infos = :additional_infos WHERE id = :id');

    $query->bindValue(':country', $customer->get_customer_country());
    $query->bindValue(':first_name', $customer->get_customer_first_name());
    $query->bindValue(':last_name', $customer->get_customer_last_name());
    $query->bindValue(':address_1', $customer->get_customer_address_1());
    $query->bindValue(':address_2', $customer->get_customer_address_2());
    $query->bindValue(':city', $customer->get_customer_city());
    $query->bindValue(':state', $customer->get_customer_state());
    $query->bindValue(':post_code', $customer->get_customer_post_code(), PDO:: PARAM_INT);
    $query->bindValue(':email', $customer->get_customer_email());
    $query->bindValue(':phone', $customer->get_customer_phone());
    $query->bindValue(':pickup_location', $customer->get_customer_pickup_location());
    $query->bindValue(':additional_infos', $customer->get_customer_additional_infos());
    $query->bindValue(':id', $customer->get_customer_id(), PDO::PARAM_INT);

    $query->execute();
  }

  public function setDb(PDO $db)
  {
    $this->_db = $db;
  }
}
?>