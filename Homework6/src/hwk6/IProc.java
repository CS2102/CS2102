package hwk6;


interface IProc<R> {
	R processNum(Num n);
	R processCellRef(CellRef c);
	R processPlus(R leftres, R rightres);
}