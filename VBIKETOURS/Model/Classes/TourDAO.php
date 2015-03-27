<?php
class TourDAO
{
  private $_db; // PDO instance

  public function __construct($db)
  {
    $this->setDb($db);
  }

  public function add(Tour $tour)
  {
    $query = $this->_db->prepare('INSERT INTO tour SET name = :name, summary = :summary, description = :description, fitness = :fitness, vehicle = :vehicle, duration = :duration, style = :style, route = :route, nb_passenger_max = :nb_passenger_max, price = :price, start_time = :start_time, validity_start = :validity_start, validity_end = :validity_end, picture = :picture');

    $query->bindValue(':name', $tour->get_name());
    $query->bindValue(':summary', $tour->get_summary());
    $query->bindValue(':description', $tour->get_description());
    $query->bindValue(':fitness', $tour->get_fitness());
    $query->bindValue(':vehicle', $tour->get_vehicle());
    $query->bindValue(':duration', $tour->get_duration());
    $query->bindValue(':style', $tour->get_style());
    $query->bindValue(':route', $tour->get_route());
    $query->bindValue(':nb_passenger_max', $tour->get_nb_passenger_max(), PDO::PARAM_INT);
    $query->bindValue(':price', $tour->get_price());
    $query->bindValue(':start_time', $tour->get_start_time());
    $query->bindValue(':validity_start', $tour->get_validity_start());
    $query->bindValue(':validity_end', $tour->get_validity_end());
    $query->bindValue(':picture', $tour->get_picture());    

    $query->execute();
  }

  public function delete(Tour $tour)
  {
    $this->_db->exec('DELETE FROM tour WHERE id = '.$tour->id());
  }

  public function get($id)
  {
    $id = (int) $id;

    $query = $this->_db->query('SELECT * FROM tour WHERE id = '.$id);
    $tours = $query->fetch(PDO::FETCH_ASSOC);

    return new Tour($tours);
  }

  public function getList()
  {
    $tours = [];
    $query = $this->_db->query('SELECT * FROM tour ORDER BY name');

    while ($datas = $query->fetch(PDO::FETCH_ASSOC))
    {
      $tours[] = new Tour($datas);
    }

    return $tours;
  }

  public function update(Tour $tour)
  {
    $query = $this->_db->prepare('UPDATE tour SET name = :name, summary = :summary, description = :description, fitness = :fitness, vehicle = :vehicle, duration = :duration, style = :style, route = :route, nb_passenger_max = :nb_passenger_max, price = :price, start_time = :start_time, validity_start = :validity_start, validity_end = :validity_end, picture = :picture WHERE id = :id');

    $query->bindValue(':name', $tour->get_name());
    $query->bindValue(':summary', $tour->get_summary());
    $query->bindValue(':description', $tour->get_description());
    $query->bindValue(':fitness', $tour->get_fitness());
    $query->bindValue(':vehicle', $tour->get_vehicle());
    $query->bindValue(':duration', $tour->get_duration());
    $query->bindValue(':style', $tour->get_style());
    $query->bindValue(':route', $tour->get_route());
    $query->bindValue(':nb_passenger_max', $tour->get_nb_passenger_max(), PDO::PARAM_INT);
    $query->bindValue(':price', $tour->get_price());
    $query->bindValue(':start_time', $tour->get_start_time());
    $query->bindValue(':validity_start', $tour->get_validity_start());
    $query->bindValue(':validity_end', $tour->get_validity_end());
    $query->bindValue(':picture', $tour->get_picture());    
    $query->bindValue(':id', $tour->get_id(), PDO::PARAM_INT);

    $query->execute();
  }

  public function setDb(PDO $db)
  {
    $this->_db = $db;
  }
}
?>