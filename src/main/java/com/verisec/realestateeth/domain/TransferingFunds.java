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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516020806106d9833981016040525160008054600160a060020a03909216600160a060020a0319909216919091179055610687806100526000396000f3006080604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631865c57d811461009d5780631b9265b8146101275780632852b71c146101315780632cdf4b7e1461015a57806368794b871461017257806390672b9d146101cb578063ab04010714610236578063cdc2895c1461024b578063e99d286614610272575b600080fd5b3480156100a957600080fd5b506100b26102a0565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100ec5781810151838201526020016100d4565b50505050905090810190601f1680156101195780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61012f610337565b005b34801561013d57600080fd5b506101466104e5565b604080519115158252519081900360200190f35b34801561016657600080fd5b5061012f6004356104f8565b34801561017e57600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261012f9436949293602493928401919081908401838280828437509497506104fd9650505050505050565b3480156101d757600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261012f958335953695604494919390910191908190840183828082843750949750508435955050506020830135926040013591506105149050565b34801561024257600080fd5b50610146610572565b34801561025757600080fd5b50610260610581565b60408051918252519081900360200190f35b34801561027e57600080fd5b5061012f73ffffffffffffffffffffffffffffffffffffffff60043516610587565b60058054604080516020601f600260001961010060018816150201909516949094049384018190048102820181019092528281526060939092909183018282801561032c5780601f106103015761010080835404028352916020019161032c565b820191906000526020600020905b81548152906001019060200180831161030f57829003601f168201915b505050505090505b90565b60035460ff16156103925760015460045460405173ffffffffffffffffffffffffffffffffffffffff9092169181156108fc0291906000818181858888f1600380549115156101000261ff0019909216919091179055505050505b600354610100900460ff16156104e35760005460028054600654600854600954600a546040517fb4d01dbf0000000000000000000000000000000000000000000000000000000081526004810186815273ffffffffffffffffffffffffffffffffffffffff95861660248301819052606483018690526084830185905260a4830184905260c0604484019081526007805460001960018216156101000201169a909a0460c4850181905297909a169963b4d01dbf9991979196959493909160e490910190879080156104a55780601f1061047a576101008083540402835291602001916104a5565b820191906000526020600020905b81548152906001019060200180831161048857829003601f168201915b5050975050505050505050600060405180830381600087803b1580156104ca57600080fd5b505af11580156104de573d6000803e3d6000fd5b505050505b565b6003805460ff1916600190811790915590565b600455565b80516105109060059060208401906105c3565b5050565b6006805473ffffffffffffffffffffffffffffffffffffffff19163373ffffffffffffffffffffffffffffffffffffffff16179055600285905583516105619060079060208701906105c3565b50600892909255600955600a555050565b6003805460ff19169055600090565b60045490565b6001805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff92909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061060457805160ff1916838001178555610631565b82800160010185558215610631579182015b82811115610631578251825591602001919060010190610616565b5061063d929150610641565b5090565b61033491905b8082111561063d57600081556001016106475600a165627a7a72305820d17b6ac775dae4969c8189cec679c855474f9ec2e7a59b2229631216738b13770029";

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

    public RemoteCall<TransactionReceipt> setState(String currentState) {
        final Function function = new Function(
                "setState", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(currentState)), 
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
