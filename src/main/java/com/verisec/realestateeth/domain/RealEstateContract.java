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
public class RealEstateContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506105f5806100206000396000f3006080604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632852b71c811461009d5780632cdf4b7e146100c657806377ac9518146100e05780639043c35c146101a5578063b4d01dbf1461020a578063ccb192f614610280578063cdc2895c146102a7578063def6bd20146102bc578063e99d2866146102d4575b600080fd5b3480156100a957600080fd5b506100b26102f5565b604080519115158252519081900360200190f35b3480156100d257600080fd5b506100de6004356102fa565b005b3480156100ec57600080fd5b506100f86004356102ff565b6040518087815260200186600160a060020a0316600160a060020a0316815260200180602001858152602001848152602001838152602001828103825286818151815260200191508051906020019080838360005b8381101561016557818101518382015260200161014d565b50505050905090810190601f1680156101925780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b3480156101b157600080fd5b506101ba6103df565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156101f65781810151838201526020016101de565b505050509050019250505060405180910390f35b34801561021657600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100de9482359460248035600160a060020a031695369594606494920191908190840183828082843750949750508435955050506020830135926040013591506104389050565b34801561028c57600080fd5b506102956104d7565b60408051918252519081900360200190f35b3480156102b357600080fd5b506102956104dd565b3480156102c857600080fd5b506102956004356104e3565b3480156102e057600080fd5b506100de600160a060020a0360043516610502565b600090565b600055565b6000818152600260208181526040808420805481850154600383015460048401546001948501805487516101009782161597909702600019011698909804601f810188900488028601880190965285855288976060978997889788978e97600160a060020a03909116969495909493909286918301828280156103c35780601f10610398576101008083540402835291602001916103c3565b820191906000526020600020905b8154815290600101906020018083116103a657829003601f168201915b5050505050935095509550955095509550955091939550919395565b6060600380548060200260200160405190810160405280929190818152602001828054801561042d57602002820191906000526020600020905b815481526020019060010190808311610419575b505050505090505b90565b6000868152600260209081526040909120805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03881617815585519091610484916001840191880190610531565b50600281019390935560038084019290925560049092019190915580546001810182556000919091527fc2575a0e9e593c00f959f8c92f12db2869c3395a3b0502d05e2516446f71f85b01929092555050565b60035490565b60005490565b60038054829081106104f157fe5b600091825260209091200154905081565b6001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061057257805160ff191683800117855561059f565b8280016001018555821561059f579182015b8281111561059f578251825591602001919060010190610584565b506105ab9291506105af565b5090565b61043591905b808211156105ab57600081556001016105b55600a165627a7a723058206611dee7fff28c310bb13ee80c530691cf242378dba0ae6b27aba3975f6072360029";

    protected RealEstateContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RealEstateContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> accept() {
        final Function function = new Function(
                "accept", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setOffer(BigInteger proposalAmount) {
        final Function function = new Function(
                "setOffer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<TransactionReceipt> getOffer() {
        final Function function = new Function(
                "getOffer", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> realestatesArray(BigInteger param0) {
        final Function function = new Function("realestatesArray", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setSeller(String s) {
        final Function function = new Function(
                "setSeller", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<RealEstateContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RealEstateContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<RealEstateContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RealEstateContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static RealEstateContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RealEstateContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RealEstateContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RealEstateContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
