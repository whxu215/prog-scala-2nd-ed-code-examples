// code-examples/AppDesign/design-by-contract/bank-account-spec.scala

import org.scalatest.{ FunSpec, ShouldMatchers } 

class BankAccountSpec extends FunSpec with ShouldMatchers { 
  describe ("Creating an account with a negative balance") {
    it ("fail because the initial balance must be positive.") {
      new BankAccount(-100.0) must throwAn[IllegalArgumentException]
    }  
  } 

  describe ("Debiting an account") {
    it ("fail if the debit amount is < 0") {
      val account = new BankAccount(100.0)
      (account.debit(-10.0)) must throwAn[IllegalArgumentException]
    }
  }
  
  describe ("Debiting an account") {
    it ("fail if the debit amount is > the balance") {
      val account = new BankAccount(100.0)
      (account.debit(110.0)) must throwAn[AssertionError]
    }
  }    
}
