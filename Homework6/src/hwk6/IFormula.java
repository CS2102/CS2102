package hwk6;


interface IFormula {
	<R> R traverse(IProc<R> f);
}