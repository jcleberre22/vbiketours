<?php
class Vehicle_DAO
{
  private $_db; // PDO instance

  public function __construct($db)
  {
    $this->setDb($db);
  }

  public function add(Vehicle $vehicle)
  {
    $query = $this->_db->prepare('INSERT INTO vehicle SET name = :name');

    $query->bindValue(':name', $vehicle->get_name());


    $query->execute();
  }

  public function delete(Vehicle $vehicle)
  {
    $this->_db->exec('DELETE FROM vehicle WHERE id = '.$vehicle->id());
  }

  public function get($id)
  {
    $id = (int) $id;

    $query = $this->_db->query('SELECT * FROM vehicle WHERE id = '.$id);
    $vehicles = $query->fetch(PDO::FETCH_ASSOC);

    return new Vehicle($vehicles);
  }

  public function getList()
  {
    $vehicles = [];

    $query = $this->_db->query('SELECT * FROM vehicle ORDER BY name');

    while ($datas = $query->fetch(PDO::FETCH_ASSOC))
    {
      $vehicles[] = new Vehicle($datas);
    }

    return $vehicles;
  }

  public function update(Vehicle $vehicle)
  {
    $query = $this->_db->prepare('UPDATE vehicle SET name = :name WHERE id = :id');

    $query->bindValue(':name', $vehicle->get_name());

    $query->bindValue(':id', $vehicle->get_id(), PDO::PARAM_INT);

    $query->execute();
  }

  public function setDb(PDO $db)
  {
    $this->_db = $db;
  }
}
?>