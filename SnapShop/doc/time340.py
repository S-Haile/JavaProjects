#Samson Haile
#CSS 340
#10/6/17
#Prog 1: TimeSpan
# This class represents a TimeSpan, and overloads operators allowing for the addition, subtraction, division, and multiplication of them (among other functions).
class TimeSpan:
    def __init__(self, seconds = 0 , minutes = 0, hours = 0):
        self.__seconds = seconds
        self.__minutes = minutes
        self.__hours = hours

        #checks if hours has decimal portion
        #is so, converts decimal portion into minutes and adds to minutes
        if isinstance(self.getHours(), int) == False:
            tempint = self.getHours() - int(self.getHours())
            tempint = tempint * 60
            self.setMinutes(int(tempint))
            self.setHours(int(self.getHours()))
                
        #checks if hours has decimal portion
        #is so, converts decimal portion into minutes and adds to minutes  
        if isinstance(self.getMinutes(), int) == False:
            tempint = self.getMinutes() - int(self.getMinutes())
            tempint = tempint * 60
            self.setSeconds(int(tempint))
            self.setMinutes(int(self.setMinutes()))


        #Checks if Minutes is greater than 60
        #if so, it increments hours, and sets the minutes to the appropriate value
        if self.getMinutes() > 60:
            tempint = self.getHours()
            tempint2 = int(self.getMinutes() / 60)
            tempint = tempint + tempint2
            self.setHours(tempint)
            tempint2 = self.getMinutes() % 60
            self.setMinutes(tempint2)

        #Checks if seconds is greater than 60
        #if so, it increments minutes, and sets the seconds to the appropriate value
        if self.getSeconds() > 60:
            tempint = self.getMinutes()
            tempint2 = int(self.getSeconds() / 60)
            tempint = tempint + tempint2
            self.setMinutes(tempint)
            tempint2 = self.getSeconds() % 60
            self.setSeconds(tempint2)

        #Checks if the number of minutes is less than zero
        #if so, it decrements the hour by one, and then sets the minutes to the appropriate number
        if self.getMinutes() < -60:
            tempint = self.getHours() - 1
            tempint2 = 60 + self.getMinutes()
            self.setHours(tempint)
            self.setMinutes(tempint2)
            if self.getMinutes() < 0:
                tempint = self.getHours() - 1
                tempint2 = 60 + self.getMinutes()
                self.setHours(tempint)
                self.setMinutes(tempint2)   
        if self.getMinutes() < 0:
            tempint = self.getHours() - 1
            tempint2 = 60 + self.getMinutes()
            self.setHours(tempint)
            self.setMinutes(tempint2)
            
        #Checks if the number of seconds is less than zero
        #if so, it decrements the minutes by one, and then sets the seconds to the appropriate number
        if self.getSeconds() < -60 and self.getMinutes() > 0:
            tempint = self.getMinutes() - 1
            tempint2 = 60 + self.getSeconds()
            self.setMinutes(tempint)
            self.setSeconds(tempint2)
            if self.getSeconds() < 0:
                tempint = self.getMinutes() - 1
                tempint2 = 60 + self.getSeconds()
                self.setMinutes(tempint)
                self.setSeconds(tempint2)   
        if self.getSeconds() < 0 and self.getMinutes() > 0:
            tempint = self.getMinutes() - 1
            tempint2 = 60 + self.getSeconds()
            self.setMinutes(tempint)
            self.setSeconds(tempint2)

        #Checks if the hours are negative but the minutes are not
        #if so, it converts the minutes to negative   
        if self.getHours() < 0 and self.getMinutes() > 0:
            tempint = self.getHours() + 1
            tempint2 = -60 + self.getMinutes()
            self.setHours(tempint)
            self.setMinutes(tempint2)
                
        #Checks if the minutes are negative but the seconds are not
        #if so, it converts the seconds to negative    
        if self.getMinutes() < 0 and self.getSeconds() > 0:
            tempint = self.getMinutes() + 1
            tempint2 = -60 + self.getSeconds()
            self.setMinutes(tempint)
            self.setSeconds(tempint2)
            
            


    #overrides the add function, allowing the ability to add two TimeSpan objects together
    def __add__(self, TS):
        tempTS = TimeSpan()
        tempTS.setTime(self.getSeconds() + TS.getSeconds(),self.getMinutes() + TS.getMinutes(), self.getHours() + TS.getHours())

        #Checks if the number of minutes when subtracted is less than zero
        #if so, it decrements the hour by one, and then sets the minutes to the appropriate number
        if tempTS.getMinutes() < 0:
            tempint = tempTS.getHours() - 1
            tempint2 = 60 + tempTS.getMinutes()
            tempTS.setHours(tempint)
            tempTS.setMinutes(tempint2)

        #Checks if the number of seconds when subtracted is less than zero
        #if so, it decrements the minutes by one, and then sets the seconds to the appropriate number
        if tempTS.getSeconds() < 0:
            tempint = tempTS.getMinutes() - 1
            tempint2 = 60 + tempTS.getSeconds()
            tempTS.setMinutes(tempint)
            tempTS.setSeconds(tempint2)

        #Checks if the number of minutes when added is greater than 60
        #if so, it increments the hour by one, and then sets the minutes to the appropriate number
        if tempTS.getMinutes() > 60:
           tempint = tempTS.getHours()
           tempint2 = int(tempTS.getMinutes() / 60)
           tempint = tempint + tempint2
           tempTS.setHours(tempint)
           tempint2 = tempTS.getMinutes() % 60
           tempTS.setMinutes(tempint2)

        #Checks if the number of seconds when added is greater than 60
        #if so, it increments the minutes by one, and then sets the seconds to the appropriate number
        if tempTS.getSeconds() > 60:
           tempint = tempTS.getMinutes()
           tempint2 = int(tempTS.getSeconds() / 60)
           tempint = tempint + tempint2
           tempTS.setMinutes(tempint)
           tempint2 = tempTS.getSeconds() % 60
           tempTS.setSeconds(tempint2)

        #Checks if the number of minutes when subtracted is less than zero
        #if so, it decrements the hour by one, and then sets the minutes to the appropriate number
        if tempTS.getMinutes() < 0:
            tempint = tempTS.getHours() - 1
            tempint2 = 60 + tempTS.getMinutes()
            tempTS.setHours(tempint)
            tempTS.setMinutes(tempint2)

        #Checks if the number of seconds when subtracted is less than zero
        #if so, it decrements the minutes by one, and then sets the seconds to the appropriate number
        if tempTS.getSeconds() < 0:
            tempint = tempTS.getMinutes() - 1
            tempint2 = 60 + tempTS.getSeconds()
            tempTS.setMinutes(tempint)
            tempTS.setSeconds(tempint2)
            
        return tempTS

    #overrides the subtraction function
    #allowing the ability to subtract one Timespan from another
    def __sub__(self, TS):
        tempTS = TimeSpan()
        tempTS.setTime(self.getSeconds() - TS.getSeconds(), self.getMinutes() - TS.getMinutes(), self.getHours() - TS.getHours())

        #Checks if the number of minutes when subtracted is less than zero
        #if so, it decrements the hour by one, and then sets the minutes to the appropriate number
        if tempTS.getMinutes() < 0:
            tempint = tempTS.getHours() - 1
            tempint2 = 60 + tempTS.getMinutes()
            tempTS.setHours(tempint)
            tempTS.setMinutes(tempint2)

        #Checks if the number of seconds when subtracted is less than zero
        #if so, it decrements the minutes by one, and then sets the seconds to the appropriate number
        if tempTS.getSeconds() < 0:
            tempint = tempTS.getMinutes() - 1
            tempint2 = 60 + tempTS.getSeconds()
            tempTS.setMinutes(tempint)
            tempTS.setSeconds(tempint2)
            
        #Checks if Minutes is greater than 60 
        #if so, it increments hours, and sets the minutes to the appropriate value
        if tempTS.getMinutes() > 60:
            tempint = tempTS.getHours()
            tempint2 = int(tempTS.getMinutes() / 60)
            tempint = tempint + tempint2
            tempTS.setHours(tempint)
            tempint2 = tempTS.getMinutes() % 60
            tempTS.setMinutes(tempint2)

        #Checks if seconds is greater than 60
        #if so, it increments minutes, and sets the seconds to the appropriate value
        if tempTS.getSeconds() > 60:
            tempint = tempTS.getMinutes()
            tempint2 = int(tempTS.getSeconds() / 60)
            tempint = tempint + tempint2
            tempTS.setMinutes(tempint)
            tempint2 = tempTS.getSeconds() % 60
            tempTS.setSeconds(tempint2)

        #Checks if the hours are negative but the minutes are not
        #if so, it converts the minutes to negative
        if tempTS.getHours() < 0 and tempTS.getMinutes() > 0:
            tempint = tempTS.getHours() + 1
            tempint2 = -60 + tempTS.getMinutes()
            tempTS.setHours(tempint)
            tempTS.setMinutes(tempint2)
            
        #Checks if the minutes are negative but the seconds are not
        #if so, it converts the seconds to negative    
        if tempTS.getMinutes() < 0 and tempTS.getSeconds() > 0:
            tempint = tempTS.getMinutes() + 1
            tempint2 = -60 + tempTS.getSeconds()
            tempTS.setMinutes(tempint)
            tempTS.setSeconds(tempint2)
        return tempTS
            
    #overrides the unary negation function
    #allowing the ability to get the negative of a given TimeSpan
    def __neg__(self):
        tempTS = TimeSpan()
        tempTS.setTime(-self.getSeconds(),-self.getMinutes(),-self.getHours())
        return tempTS
    
    #overrides the string function
    #allowing us to neatly print a TimeSpan
    def __str__(self):
        return " Hours: " + str(self.getHours()) + ", Minutes: " + str(self.getMinutes()) + ", Seconds: " + str(self.getSeconds())

    #overrides equals
    #allowing us to check if two TimeSpans are equal
    def __eq__(self, TS):
        if self.getHours() == TS.getHours() and self.getMinutes() == TS.getMinutes() and self.getSeconds() == TS.getSeconds():
            return True
        else:
            return False

    #overrides not equal
    #allowing us to check if two TimeSpans are not equal
    def __ne__(self, TS):
        if self == TS:
            return False
        else:
            return True

    #overrides less than
    #allowing us to check if one TimeSpan is less than another
    def __lt__(self, TS):
        Tempint = (self.getHours() *60) + self.getMinutes() + (self.getSeconds()/60)
        tempint2 = (TS.getHours() * 60) + TS.getMinutes() + (TS.getSeconds()/60)

        if Tempint < tempint2:
            return True
        else:
            return False

    #overrides less than or equal to
    #allowing us to check if one TimeSpan is less than or equal to another
    def __le__(self, TS):
        Tempint = (self.getHours() *60) + self.getMinutes() + (self.getSeconds()/60)
        tempint2 = (TS.getHours() * 60) + TS.getMinutes() + (TS.getSeconds()/60)

        if self == TS or Tempint < tempint2:
            return True
        else:
            return False
    #overrides greater than 
    #allowing us to check if one TimeSpan is greater than another
    def __gt__(self, TS):
        Tempint = (self.getHours() *60) + self.getMinutes() + (self.getSeconds()/60)
        tempint2 = (TS.getHours() * 60) + TS.getMinutes() + (TS.getSeconds()/60)

        if Tempint > tempint2:
            return True
        else:
            return False

    #overrides greater than or equal to
    #allowing us to check if one TimeSpan is greater than or equal to another
    def __ge__(self, TS):
        Tempint = (self.getHours() *60) + self.getMinutes() + (self.getSeconds()/60)
        tempint2 = (TS.getHours() * 60) + TS.getMinutes() + (TS.getSeconds()/60)

        if self == TS or Tempint > tempint2:
            return True
        else:
            return False

    #returns the number of hours of our TimeSpan object
    def getHours(self):
        return self.__hours

    #returns the number of mintues of our TimeSpan object
    def getMinutes(self):
        return self.__minutes

    #returns the number of seconds of our TimeSpan object
    def getSeconds(self):
        return self.__seconds

    #sets the numbers of hours of the TimeSpan
    def setHours(self, hours):
        self.__hours = hours

    #sets the numbers of minutes of the TimeSpan
    def setMinutes(self, minutes):
        self.__minutes = minutes

    #sets the numbers of seconds of the TimeSpan
    def setSeconds(self, seconds):
        self.__seconds = seconds

    #sets the time (hours, seconds, and minutes) of the Timespan
    def setTime(self, seconds, minutes, hours):
        self.__seconds = seconds
        self.__minutes = minutes
        self.__hours = hours
