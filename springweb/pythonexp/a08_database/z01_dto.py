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
    distance:float
    population:int
    has_oxygen:str

# ZOMBIE_ITEMS item_id item_id item_name durability description
@dataclass
class ZombieItemDTO:
    item_id:int
    item_name:str
    durability:int
    description:str

# SECRET_GADGETS SecretGadgetDTO gadget_id code_name danger_level status function
@dataclass
class SecretGadgetDTO:
    gadget_id:int
    code_name:str
    danger_level:int
    status:str
    function:str
# MAGIC_VENDING MagicVendingSchDTO MagicVendingDTO
# id product_name price effect
@dataclass
class MagicVendingSchDTO:
    product_name:str
    effect:str

@dataclass
class MagicVendingDTO:
    id:int
    product_name:str
    price:int
    effect:str


@dataclass
class MagicVendingInsDTO:
    product_name:str
    price:int
    effect:str

