package assignment6;

import java.util.Arrays;

public class NumberCollections
{
		//instance variables
		private int[] numberArray = null;  // numberArray
		private int count = 0;  //will be different than numberArray.length

		//the constructor
		public NumberCollections(int arraySize)
		{
			numberArray = new int[arraySize];
			// to grow the array - just an example as placeholder
			// if (currentSize >= inputs.length)
			// {inputs=Arrays.copyOf(inputs, 2*inputs.length);}
			// inputs[currentSize] = in.nextDouble();
			// currentSize++;
		}

		// method - helper method -returns index of the number specified by the parameter
		private int indexOf(int searchingNum)
		{
			for (int index=0; index < count; index++)
			{
				if (numberArray[index] == searchingNum)
				{
					return index;
				}
			}
			return -1;
		}

		// method - will add numberToAdd to the smallest index
		// my brain hurts and I have no idea what I am doing
		public boolean addNumber (int numberToAdd)
		{
			boolean result = true;
			if (indexOf(numberToAdd) != -1)
			{
				result = false;
			}
			return result;
		}

		// method - finds the maximum number among stored at the time
		public int findMax()
		{
			int max = numberArray[0];
			// if (numberArray.length !=0)  make sure the array is not empty
			for (int index = 1; index < count; index++)
			{
				if ( numberArray[index] > max)
				{
					max = numberArray[index];
				}
			}
			return max;
		}


		// method - finds the minimum number among stored at the time
		public int findMin()
		{
			int min = numberArray[0];
			for (int index = 1; index < numberArray.length; index++)
			{
				if (numberArray[index] < min)
				{
					min = numberArray[index];
				}
			}
			return min;
		}

		// method - computes sum of numbers stored in array so far
		public int computeSum()
		{
			int sum = 0;
			for (int index = 0; index < count; index++)
			{
				sum += numberArray[index];
			}
			return sum;
		}

		// method - returns a string containing a list of numbers stored in array
		public String toString()
		{
			String result = "\n numberArray: {";//remove the \n and numberArray, just leave the { 
			for (int index = 0; index < count; index++)
			{
				if (index >= 0)
				{
					result += ".";
					result += numberArray[index];
				}
				else if (index == count)
				{
					result += numberArray[index];
				}
			}
			return result + "}";
		}
}