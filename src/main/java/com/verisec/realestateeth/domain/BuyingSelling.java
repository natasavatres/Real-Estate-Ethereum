package com.verisec.realestateeth.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class BuyingSelling extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5061054e806100206000396000f30060806040526004361061006c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166377ac951881146100715780639043c35c14610150578063b4d01dbf146101b5578063ccb192f61461023a578063def6bd2014610261575b600080fd5b34801561007d57600080fd5b50610089600435610279565b604051808781526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001858152602001848152602001838152602001828103825286818151815260200191508051906020019080838360005b838110156101105781810151838201526020016100f8565b50505050905090810190601f16801561013d5780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561015c57600080fd5b50610165610368565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156101a1578181015183820152602001610189565b505050509050019250505060405180910390f35b3480156101c157600080fd5b50604080516020600460443581810135601f8101849004840285018401909552848452610238948235946024803573ffffffffffffffffffffffffffffffffffffffff1695369594606494920191908190840183828082843750949750508435955050506020830135926040013591506103c19050565b005b34801561024657600080fd5b5061024f610465565b60408051918252519081900360200190f35b34801561026d57600080fd5b5061024f60043561046b565b6000818152602081815260408083208054600280830154600384015460048501546001958601805488516101009882161598909802600019011694909404601f810189900489028701890190975286865288976060978997889788978e9773ffffffffffffffffffffffffffffffffffffffff90921696909591949093919291869183018282801561034c5780601f106103215761010080835404028352916020019161034c565b820191906000526020600020905b81548152906001019060200180831161032f57829003601f168201915b5050505050935095509550955095509550955091939550919395565b606060018054806020026020016040519081016040528092919081815260200182805480156103b657602002820191906000526020600020905b8154815260200190600101908083116103a2575b505050505090505b90565b600086815260208181526040909120805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff88161781558551909161041891600184019188019061048a565b506002810193909355600383019190915560049091015550506001805480820182556000919091527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf60155565b60015490565b600180548290811061047957fe5b600091825260209091200154905081565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106104cb57805160ff19168380011785556104f8565b828001600101855582156104f8579182015b828111156104f85782518255916020019190600101906104dd565b50610504929150610508565b5090565b6103be91905b80821115610504576000815560010161050e5600a165627a7a72305820384cf37e60bfda8efaaa4d73604088eb733241aea96da3639fa5f56dc5b896250029";

    protected BuyingSelling(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BuyingSelling(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>> getRealEstate(BigInteger id) {
        final Function function = new Function("getRealEstate", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<List> getAllRealEstates() {
        final Function function = new Function("getAllRealEstates", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setRealEstate(BigInteger id, String o, String rea, BigInteger a, BigInteger cd, BigInteger p) {
        final Function function = new Function(
                "setRealEstate", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Address(o), 
                new org.web3j.abi.datatypes.Utf8String(rea), 
                new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(cd), 
                new org.web3j.abi.datatypes.generated.Uint256(p)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> countRealEstates() {
        final Function function = new Function("countRealEstates", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> realestatesArray(BigInteger param0) {
        final Function function = new Function("realestatesArray", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<BuyingSelling> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BuyingSelling.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BuyingSelling> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BuyingSelling.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static BuyingSelling load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BuyingSelling(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static BuyingSelling load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BuyingSelling(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
