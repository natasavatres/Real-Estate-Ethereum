pragma solidity ^0.4.20;

contract BuyingSelling {

struct RealEstate{
address owner;
string REaddress;
uint area;
uint centerDistance;
uint price;
}

mapping (uint => RealEstate) realestates;

uint[] public realestatesArray;

function setRealEstate(uint id, address o, string rea, uint a, uint cd, uint p) public {
    var realEstate= realestates[id];
    realEstate.owner=o;
     realEstate.REaddress=rea;
     realEstate.area=a;
     realEstate.centerDistance=cd;
     realEstate.price=p;
     
     realestatesArray.push(id) -1;
    
}

function getAllRealEstates() view public returns(uint[]){
    return realestatesArray;
}

function getRealEstate(uint id) view public returns(uint, address, string, uint, uint, uint) {
    return (id, realestates[id].owner, realestates[id].REaddress, realestates[id].area, realestates[id].centerDistance, realestates[id].price);
}

function countRealEstates() public constant returns (uint){
    return realestatesArray.length;
}

}

contract TransferingFunds{
    
    BuyingSelling bs;
    address private seller;
    uint private i;
    bool private accepted;
    bool private sent;
    uint private amount;
    string private state;

    struct RealEstate{
    address owner;
    string REaddress;
    uint area;
    uint centerDistance;
    uint price;
    }
    
function TransferingFunds(address t) public{
    bs=BuyingSelling(t);
}
    
    RealEstate rs;
    
function changeOwner(uint id, string rea, uint a, uint cd, uint p) public {
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

function setOffer(uint proposalAmount) public{
    amount=proposalAmount;
}

function setState(string currentState) public{
    state=currentState;
}

function getState() public constant returns(string) {
    return state;
}

function getOffer() public constant returns(uint) {
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
       sent=seller.send(amount);
   }
   if(sent){
        bs.setRealEstate(i,rs.owner, rs.REaddress, rs.area, rs.centerDistance, rs.price);
        //selfdestruct(seller);
        }
    
}

}