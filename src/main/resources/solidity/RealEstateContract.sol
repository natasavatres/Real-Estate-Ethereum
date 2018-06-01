pragma solidity ^0.4.20;

contract BuyingSelling {

struct RealEstate{
address owner;
string REaddress;
int area;
int centerDistance;
int price;
}

mapping (int => RealEstate) realestates;

int[] public realestatesArray;

function setRealEstate(int id, address o, string rea, int a, int cd, int p) public {
    var realEstate= realestates[id];
    realEstate.owner=o;
     realEstate.REaddress=rea;
     realEstate.area=a;
     realEstate.centerDistance=cd;
     realEstate.price=p;
     
     realestatesArray.push(id) -1;
    
}

function getAllRealEstates() view public returns(int[]){
    return realestatesArray;
}

function getRealEstate(int id) view public returns(int, address, string, int, int, int) {
    return (id, realestates[id].owner, realestates[id].REaddress, realestates[id].area, realestates[id].centerDistance, realestates[id].price);
}

function countRealEstates() view public returns (uint){
    return realestatesArray.length;
}

}

contract TransferingFounds{
    
    BuyingSelling bs;
    address private seller;
    int private i;
    bool private accepted;
    bool private sent;
    int private amount;
    
    struct RealEstate{
    address owner;
    string REaddress;
    int area;
    int centerDistance;
    int price;
    }
    
function TransferingFounds(address t) public{
    bs=BuyingSelling(t);
}
    
    RealEstate rs;
    
function changeOwner(int id, string rea, int a, int cd, int p) public {
    rs.owner=msg.sender;
    i=id;
    rs.REaddress=rea;
    rs.area=a;
    rs.centerDistance=cd;
    rs.price=p;
}   
    
    
function setSeller(address s) public{
   seller=s;
}

function setOffer(int proposalAmount) public{
    amount=proposalAmount;
}

function getOffer() public returns(int) {
    return amount;
}

//function setId(uint i) public{
//    id=i;
//}

//function getId() public returns (uint){
//   return id;
//}

function accept() public returns(bool) {
   return accepted=true;
}

function decline() public returns(bool) {
   return accepted=false;
}

function pay() payable public{
   if(accepted){
       sent=seller.send(uint256(amount));
   }
   if(sent){
        bs.setRealEstate(i,rs.owner, rs.REaddress, rs.area, rs.centerDistance, rs.price);
        //selfdestruct(seller);
        }
    
}

}