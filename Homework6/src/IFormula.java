
interface IFormula {
	<R> R traverse(IProc<R> f);
}