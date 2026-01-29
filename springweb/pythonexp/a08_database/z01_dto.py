from  dataclasses import dataclass
from datetime import datetime
@dataclass
class DeptDTO:
    deptno : int
    dname : str
    loc : str

@dataclass
class GourmetDTO:
    id : int
    name : str
    category : str
    keyword : str
    decription : str
    rating : int
    create_at : datetime

@dataclass
class HeroMartDTO:
    item_id:int
    item_name:str
    category:str
    price:int 
    stock:int 
    power_level:float 
    status:str

# planet_id planet_name galaxy_name distance population has_oxygen
# GALAXY_PLANET   GalaxyPlanetDTO
@dataclass
class GalaxyPlanetDTO:
    planet_id:int
    planet_name:str
    galaxy_name:str
    distance:int
    population:int
    has_oxygen:str        