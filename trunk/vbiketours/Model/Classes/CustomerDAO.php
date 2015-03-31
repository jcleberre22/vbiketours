<?php
class Customer_DAO
{
  private $_db; // PDO instance

  public function __construct($db)
  {
    $this->setDb($db);
  }

  public function add(Customer $customer)
  {
    $query = $this->_db->prepare('INSERT INTO customer SET country = :country, first_name = :first_name, last_name = :last_name, adress = :adress, city = :city, email = :email, phone = :phone, pickup_location = :pickup_location, additional_infos = :additional_infos');

    $query->bindValue(':country', $customer->get_country());
    $query->bindValue(':first_name', $customer->get_first_name());
    $query->bindValue(':last_name', $customer->get_last_name());
    $query->bindValue(':adress', $customer->get_adress());
    $query->bindValue(':city', $customer->get_city());
    $query->bindValue(':email', $customer->get_email());
    $query->bindValue(':phone', $customer->get_phone());
    $query->bindValue(':pickup_location', $customer->get_pickup_location());
    $query->bindValue(':additional_infos', $customer->get_additional_infos());

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
    $customers = $query->fetch(PDO::FETCH_ASSOC);

    return new Customer($customers);
  }

  public function getList()
  {
    $customers = [];

    $query = $this->_db->query('SELECT * FROM customer ORDER BY country');

    while ($datas = $query->fetch(PDO::FETCH_ASSOC))
    {
      $customers[] = new Customer($datas);
    }

    return $customers;
  }

  public function update(Customer $customer)
  {
    $query = $this->_db->prepare('UPDATE customer SET country = :country, first_name = :first_name, last_name = :last_name, adress = :adress, city = :city, email = :email, phone = :phone, pickup_location = :pickup_location, additional_infos = :additional_infos WHERE id = :id');

    $query->bindValue(':country', $customer->get_country());
    $query->bindValue(':first_name', $customer->get_first_name());
    $query->bindValue(':last_name', $customer->get_last_name());
    $query->bindValue(':adress', $customer->get_adress());
    $query->bindValue(':city', $customer->get_city());
    $query->bindValue(':email', $customer->get_email());
    $query->bindValue(':phone', $customer->get_phone());
    $query->bindValue(':pickup_location', $customer->get_pickup_location());
    $query->bindValue(':additional_infos', $customer->get_additional_infos());
    $query->bindValue(':id', $customer->get_id(), PDO::PARAM_INT);

    $query->execute();
  }

  public function setDb(PDO $db)
  {
    $this->_db = $db;
  }
}
?>