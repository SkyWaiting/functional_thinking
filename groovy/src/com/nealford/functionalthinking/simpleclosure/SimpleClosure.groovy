package com.nealford.functionalthinking.simpleclosure

class Employee {
    def name, salary
}

def paidMore(amount) {
    return {Employee e -> e.salary > amount}
}

isHighPaid = paidMore(100000)

def Smithers = new Employee(name: "Smithers", salary: 120000)
def Homer = new Employee(name: "Homer", salary: 80000)
println isHighPaid(Smithers)
println isHighPaid(Homer)

isHighPaid = paidMore(200000)
println isHighPaid(Smithers)
println isHighPaid(Homer)
def Burns = new Employee(name: "Monty", salary: 1000000)
println isHighPaid(Burns)