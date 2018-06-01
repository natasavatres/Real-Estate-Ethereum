package com.verisec.realestateeth.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class TransferingFunds extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060405160208061073a833981016040525160008054600160a060020a03909216600160a060020a03199092169190911790556106e8806100526000396000f30060806040526004361061008d5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631865c57d81146100925780631b9265b81461011c5780632852b71c146101265780632cdf4b7e1461014f57806390672b9d14610167578063ab040107146101d2578063cdc2895c146101e7578063e99d28661461020e575b600080fd5b34801561009e57600080fd5b506100a761023c565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100e15781810151838201526020016100c9565b50505050905090810190601f16801561010e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101246102d3565b005b34801561013257600080fd5b5061013b610481565b604080519115158252519081900360200190f35b34801561015b57600080fd5b506101246004356104de565b34801561017357600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101249583359536956044949193909101919081908401838280828437509497505084359550505060208301359260400135915061052b9050565b3480156101de57600080fd5b5061013b610589565b3480156101f357600080fd5b506101fc6105e2565b60408051918252519081900360200190f35b34801561021a57600080fd5b5061012473ffffffffffffffffffffffffffffffffffffffff600435166105e8565b60058054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156102c85780601f1061029d576101008083540402835291602001916102c8565b820191906000526020600020905b8154815290600101906020018083116102ab57829003601f168201915b505050505090505b90565b60035460ff161561032e5760015460045460405173ffffffffffffffffffffffffffffffffffffffff9092169181156108fc0291906000818181858888f1600380549115156101000261ff0019909216919091179055505050505b600354610100900460ff161561047f5760005460028054600654600854600954600a546040517fb4d01dbf0000000000000000000000000000000000000000000000000000000081526004810186815273ffffffffffffffffffffffffffffffffffffffff95861660248301819052606483018690526084830185905260a4830184905260c0604484019081526007805460001960018216156101000201169a909a0460c4850181905297909a169963b4d01dbf9991979196959493909160e490910190879080156104415780601f1061041657610100808354040283529160200191610441565b820191906000526020600020905b81548152906001019060200180831161042457829003601f168201915b5050975050505050505050600060405180830381600087803b15801561046657600080fd5b505af115801561047a573d6000803e3d6000fd5b505050505b565b60408051808201909152600d8082527f4f6666657241636365707465640000000000000000000000000000000000000060209092019182526000916104c99160059190610624565b50506003805460ff1916600190811790915590565b60048190556040805180820190915260088082527f4f66666572536574000000000000000000000000000000000000000000000000602090920191825261052791600591610624565b5050565b6006805473ffffffffffffffffffffffffffffffffffffffff19163373ffffffffffffffffffffffffffffffffffffffff1617905560028590558351610578906007906020870190610624565b50600892909255600955600a555050565b60408051808201909152600d8082527f4f666665724465636c696e65640000000000000000000000000000000000000060209092019182526000916105d19160059190610624565b50506003805460ff19169055600090565b60045490565b6001805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff92909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061066557805160ff1916838001178555610692565b82800160010185558215610692579182015b82811115610692578251825591602001919060010190610677565b5061069e9291506106a2565b5090565b6102d091905b8082111561069e57600081556001016106a85600a165627a7a723058200934aba0972bcb31227f15fd09ea472aba9cb5c6a5f44c5db4aa76c8b72acabe0029";

    protected TransferingFunds(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransferingFunds(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> getState() {
        final Function function = new Function("getState", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> pay(BigInteger weiValue) {
        final Function function = new Function(
                "pay", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
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

    public RemoteCall<TransactionReceipt> changeOwner(BigInteger id, String rea, BigInteger a, BigInteger cd, BigInteger p) {
        final Function function = new Function(
                "changeOwner", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(rea), 
                new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(cd), 
                new org.web3j.abi.datatypes.generated.Uint256(p)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> decline() {
        final Function function = new Function(
                "decline", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getOffer() {
        final Function function = new Function("getOffer", 
                Arrays.<Type>asList(), 
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

    public static RemoteCall<TransferingFunds> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(t)));
        return deployRemoteCall(TransferingFunds.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<TransferingFunds> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(t)));
        return deployRemoteCall(TransferingFunds.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static TransferingFunds load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferingFunds(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TransferingFunds load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferingFunds(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
